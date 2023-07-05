const BASE_URL = "http://localhost:8080/ticket"

const ServicesTicket = {};

//Get all tickets Page By owner
ServicesTicket.GettAllTicketPageByOwner = async (Token, page, size) => {//params: page, size and token
    try {
            const Response = await fetch(`${BASE_URL}/owner/page?page=${page}&size=${size}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}

ServicesTicket.GettAllTickets = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/all`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}

ServicesTicket.CreateTicket = async (Token, tier, user, owner, active, event, qr, category) => {

    const Response = await fetch(`${BASE_URL}/`, {
        method: "POST",
        headers: {
            Authorization: `Bearer ${Token}`,
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            tier: `${tier}`,
            user: `${user}`,
            owner: `${owner}`,
            active: `${active}`,
            event: `${event}`,
            qr: `${qr}`,
            category: `${category}`
        })
    })
    if (Response.ok) {
        const Token = await Response.json()
        return Token
    }
    return {};/* no user found */
}


//Toggle active ticket
ServicesTicket.ToggleActiveTicket = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/active/${id}`, {
            method: "PATCH",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        console.log(data)
        return data
    } catch (error) {
        console.log(error)
    }
}

//get ticket by id
ServicesTicket.GetTicketById = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/${id}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//Find ticket by owner
ServicesTicket.FindTicketByOwner = async (Token, owner) => {
    try {
        const Response = await fetch(`${BASE_URL}/owner/${owner}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//Change ticket owner
ServicesTicket.ChangeTicketOwner = async (Token, userowner, newowner, hash) => {
    try {
        const Response = await fetch(`${BASE_URL}/owner/`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${Token}`,
                "Content-type": "application/json"
            },
            body: JSON.stringify({/* Convert the data to json */
            hash: `${hash}`,
            userowner: `${userowner}`,
            newowner: `${newowner}`
            })
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//-------------------------------------------------------------

//Category tickets

//find all category tickets

ServicesTicket.FindAllCategoryTickets = async (Token) => { 
    try {
        const Response = await fetch(`${BASE_URL}/category/all`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//Create category ticket

ServicesTicket.CreateCategoryTicket = async (Token, price, capacity) => {
    try {
        const Response = await fetch(`${BASE_URL}/category/`, {
            method: "POST",
            headers: {
                Authorization: `Bearer ${Token}`,
                "Content-type": "application/json"
            },
            body: JSON.stringify({/* Convert the data to json */
                price: `${price}`,
                capacity: `${capacity}`
            })
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//delete category ticket

ServicesTicket.DeleteCategoryTicket = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/category/${id}`, {
            method: "DELETE",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//update category ticket
ServicesTicket.UpdateCategoryTicket = async (Token, id, price, capacity) => {
    try {
        const Response = await fetch(`${BASE_URL}/category/${id}`, {
            method: "PUT",
            headers: {
                Authorization: `Bearer ${Token}`,
                "Content-type": "application/json"
            },
            body: JSON.stringify({/* Convert the data to json */
                price: `${price}`,
                capacity: `${capacity}`
            })
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//-------------------------------------------------------------

//QR tickets

//find all QR tickets
ServicesTicket.FindAllQRTickets = async (Token) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/all`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//Create QR ticket
ServicesTicket.CreateQRTicket = async (Token, time, code, user) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/`, {
            method: "POST",
            headers: {
                Authorization: `Bearer ${Token}`,
                "Content-type": "application/json"
            },
            body: JSON.stringify({/* Convert the data to json */
                time: `${time}`,
                code: `${code}`,
                user: `${user}`
            })
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//delete QR ticket
ServicesTicket.DeleteQRTicket = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/${id}`, {
            method: "DELETE",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//find by user id
ServicesTicket.FindByUserId = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/user/${id}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//get QR ticket by id
ServicesTicket.GetQRTicketById = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/${id}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

//Get time by id
ServicesTicket.GetTimeById = async (Token, id) => {
    try {
        const Response = await fetch(`${BASE_URL}/QR/time/${id}`, {
            method: "GET",
            headers: {
                Authorization: `Bearer ${Token}`
            }
        })
        const data = await Response.json()
        return data
    } catch (error) {
        console.log(error)
    }
}

export default ServicesTicket;/* Exporting services  */

//Tickets

//GettAllTicketPageByOwner(Token, page, size)

//GettAllTickets(Token)

//CreateTicket(Token, tier, user, owner, active, event, qr, category)

//ToggleActiveTicket(Token, id)

//GetTicketById(Token, id)

//FindTicketByOwner(Token, owner)

//ChangeTicketOwner(Token, userowner, newowner, hash)

//-------------------------------------------------------------

//Category tickets

//FindAllCategoryTickets(Token)

//CreateCategoryTicket(Token, price, capacity)

//DeleteCategoryTicket(Token, id)

//UpdateCategoryTicket(Token, id, price, capacity)

//-------------------------------------------------------------

//QR tickets

//FindAllQRTickets(Token)

//CreateQRTicket(Token, time, code, user)

//DeleteQRTicket(Token, id)

//FindByUserId(Token, id)

//GetQRTicketById(Token, id)

//GetTimeById(Token, id)

//-------------------------------------------------------------
