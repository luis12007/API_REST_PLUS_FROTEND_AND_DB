const BASE_URL = "http://localhost:8080/register"

const ServicesAssign = {};

//Get all assignments
ServicesAssign.GetAllAssign = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/all`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`,
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}

//get all assignments by user id
ServicesAssign.GetAllAssignByUserId = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/user/${id}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`,
                }
            })
            console.log(Response)
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}


ServicesAssign.GetAllAssignByEventId = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/event/${id}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`,
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}

ServicesAssign.GetAllAssignByGroup = async (Token, group) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/group/${group}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`,
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
    } catch (error) {
        console.log(error)
    }
}




export default ServicesAssign;/* Exporting services  */

// Get all assignments

//GetallAssign(Token)

//GetAllAssignByEventId(Token, id)

//GetAllAssignByGroup(Token, group)

//GetAllAssignByUserId(Token, id)

//GetAllAssignByGroup(Token, id)