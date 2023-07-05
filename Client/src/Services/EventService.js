const BASE_URL = "http://localhost:8080/event"

const ServicesEvent = {};

//Tickets

//Get all events Page by category
ServicesEvent.GetAllEventPageByCategory = async (Token, cat, page, size) => {//params: page, size and token
    try {
            const Response = await fetch(`${BASE_URL}/all/category/page?cat=${cat}&page=${page}&size=${size}`, {
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

//Get page by Title
ServicesEvent.GetEventPageByTitle = async (Token, title, page, size) => {//params: page, size and token
    try {
            const Response = await fetch(`${BASE_URL}/all/title/page?title=${title}&page=${page}&size=${size}`, {
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

//Get All Events
ServicesEvent.GetAllEvents = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/all`, {
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

//Get event by id
ServicesEvent.GetEventById = async (Token, id) => {//params:  token
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

//Get event by category id
ServicesEvent.GetEventByCategoryId = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/category/${id}`, {
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

//Create event
ServicesEvent.CreateEvent = async (Token, tittle, date, hour, category, collaborator, image, duration, panic, estado) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/`, {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${Token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({/* Convert the data to json */
                    tittle: `${tittle}`,
                    date: `${date}`,
                    hour: `${hour}`,
                    category: `${category}`,
                    collaborator: `${collaborator}`,
                    image: `${image}`,
                    duration: `${duration}`,
                    panic: `${panic}`,
                    estado: `${estado}`
                })
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Toggle event state
ServicesEvent.ToggleEventState = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/state/${id}`, {
                method: "PATCH",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }   
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Toggle event panic
ServicesEvent.ToggleEventPanic = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/panic/${id}`, {
                method: "PATCH",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//-------------------------------------------------------------

// Event location

//Get all event location
ServicesEvent.GetAllEventLocation = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/location/all`, {
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

//Find event location by id
ServicesEvent.FindEventLocationById = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/location/${id}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return null;/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Create event location
ServicesEvent.CreateEventLocation = async (Token, rating, name, event) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/location/`, {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${Token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({/* Convert the data to json */
                    rating: `${rating}`,
                    name: `${name}`,
                    event: `${event}`
                })
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Delete event location by id
ServicesEvent.DeleteEventLocationById = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/location/${id}`, {
                method: "DELETE",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Sponsor event

//Get all event sponsor

ServicesEvent.GetAllEventSponsor = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/sponsor/all`, {
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

//Get sponsor by event id
ServicesEvent.GetSponsorByEventId = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/sponsor/${id}`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Create event sponsor
ServicesEvent.CreateEventSponsor = async (Token, name, event) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/sponsor/`, {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${Token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({/* Convert the data to json */
                    name: `${name}`,
                    event: `${event}`
                })
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Delete Sponsor by id
ServicesEvent.DeleteSponsorById = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/sponsor/${id}`, {
                method: "DELETE",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//-------------------------------------------------------------

// Event Collaborator

// Find all event collaborator
ServicesEvent.GetAllEventCollaborator = async (Token) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/collaborator/all`, {
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

//Create event collaborator
ServicesEvent.CreateEventCollaborator = async (Token, name) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/collaborator/`, {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${Token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({/* Convert the data to json */
                    name: `${name}`
                })
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//Delete event collaborator by id
ServicesEvent.DeleteEventCollaboratorById = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/collaborator/${id}`, {
                method: "DELETE",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

//-------------------------------------------------------------

// Event Category

//Find all event category
ServicesEvent.GetAllEventCategory = async (Token) => {//params:  token
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

//Create event category

ServicesEvent.CreateEventCategory = async (Token, name) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/category/`, {
                method: "POST",
                headers: {
                    Authorization: `Bearer ${Token}`,
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({/* Convert the data to json */
                    name: `${name}`
                })
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}

// Delete event category by id
ServicesEvent.DeleteEventCategoryById = async (Token, id) => {//params:  token
    try {
            const Response = await fetch(`${BASE_URL}/category/${id}`, {
                method: "DELETE",
                headers: {
                    Authorization: `Bearer ${Token}`
                }
            })
            if (Response.ok) {
                const Token = await Response.json()
                return Token
            }
            return {};/* no user found */
    } catch (error) {
        console.log(error)
    }
}


//-------------------------------------------------------------

export default ServicesEvent;/* Exporting services  */

//-------------------------------------------------------------

//Tickets

//GetAllEventPageByCategory(id, page, size, sort, Token)

//GetEventPageByTitle(title, page, size, sort, Token)

//GetAllEvents(page, size, sort, Token)

//GetEventById(id, Token)

//CreateEvent(Token, title, description, startDate, endDate, location, category, sponsor, collaborator)

//UpdateEventById(Token, id, title, description, startDate, endDate, location, category, sponsor, collaborator)

//DeleteEventById(Token, id)

//-------------------------------------------------------------

//Sponsor

//GetAllEventSponsor(Token)

//GetSponsorByEventId(Token, id)

//CreateEventSponsor(Token, name, event)

//DeleteSponsorById(Token, id)

//-------------------------------------------------------------

//Collaborator

//GetAllEventCollaborator(Token)

//CreateEventCollaborator(Token, name)

//DeleteEventCollaboratorById(Token, id)

//-------------------------------------------------------------

//Category

//GetAllEventCategory(Token)

//CreateEventCategory(Token, name)

//DeleteEventCategoryById(Token, id)


//-------------------------------------------------------------

//Sponsor

//GetAllEventSponsor(Token)

//GetSponsorByEventId(Token, id)

//CreateEventSponsor(Token, name, event)

//DeleteSponsorById(Token, id)

//-------------------------------------------------------------



