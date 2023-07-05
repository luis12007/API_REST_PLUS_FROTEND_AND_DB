const BASE_URL = "http://localhost:8080/user"

const ServicesUser = {};

//Public Routes (no token needed) for user
ServicesUser.SingUp = async (Auth, User = "", Pass = null, Mail, Active) => {

    const Response = await fetch(`${BASE_URL}/auth/create`, {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            authentication: `${Auth}`,
            username: `${User}`,
            password: `${Pass}`,
            mail: `${Mail}`,
            active: `${Active}`
        })
    })
    const response = await Response
    return response
}

ServicesUser.SingIn = async (User, Pass = null) => {

    const Response = await fetch(`${BASE_URL}/auth/login`, {
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            identifier: `${User}`,
            password: `${Pass}`
        })
    })
    if (Response.ok) {
        const Token = await Response.json()
        return Token
    }
    return null;/* no user found */
}

//owmai function to get info of the user from the token
ServicesUser.Owmail = async (Token) => {
    const Response = await fetch(`${BASE_URL}/owami`, {
        method: "GET",
        headers: {
            Authorization: `Bearer ${Token}`,
        }
    })
    const data = await Response.json()
    return data
}

//Private Routes (token needed) for user

//Get all users by page
ServicesUser.GetAllUsersPage = async (Token, page, size) => {//params: page, size and token
    try {
        const Response = await fetch(`${BASE_URL}/all/page?page=${page}&size=${size}`, {
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

//get all users
ServicesUser.GetAllUsers = async (Token, role) => {//params:  token
    try {
        if (role === "admin") {
            const Response = await fetch(`${BASE_URL}/all`, {
                method: "GET",
                headers: {
                    Authorization: `Bearer ${Token}`,
                }
            })
            const data = await Response.json()
            console.log(data)
            return data
        }
    } catch (error) {
        console.log(error)
    }
}

//get user by id
ServicesUser.GetUserById = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/${id}`, {
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

//Delete User
ServicesUser.DeleteUserId = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/delete/${id}`, {
            method: "DELETE",
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

//Toggle Auth
ServicesUser.ToggleAuthUser = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/auth/${id}`, {
            method: "PATCH",
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

//Toggle Active
ServicesUser.ToggleActiveUser = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/active/${id}`, {
            method: "PATCH",
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

//-------------------------------------------------------------

//Movement services

ServicesUser.AddMovement = async (Token, id, movement, descrip) => {

    const Response = await fetch(`${BASE_URL}/movement/${id}`, {
        method: "POST",
        headers: {
            Authorization: `Bearer ${Token}`,
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            movement: `${movement}`,
            descrip: `${descrip}`
        })
    })
    if (Response.ok) {
        const response = await Response.json()
        return response
    }
    return {};/* error */
}

ServicesUser.DeleteMovement = async (Token, id) => {

    const Response = await fetch(`${BASE_URL}/movement/${id}`, {
        method: "DELETE",
        headers: {
            Authorization: `Bearer ${Token}`
        }
    })
    if (Response.ok) {
        const response = await Response.json()
        return response
    }
    return {};/* error */
}

ServicesUser.GetAllMovement = async (Token) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/movement/all`, {
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

ServicesUser.GetMovementByUserId = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/movement/${id}`, {
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

ServicesUser.GetAllMovementPage = async (Token, page, size) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/movement/all/page?page=${page}&size=${size}`, {
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


//-------------------------------------------------------------


//Assignment services

ServicesUser.AddAssignment = async (Token, rol, user) => {

    const Response = await fetch(`${BASE_URL}/assignment`, {
        method: "POST",
        headers: {
            Authorization: `Bearer ${Token}`,
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            rol: `${rol}`,
            user: `${user}`
        })
    })
    if (Response.ok) {
        const response = await Response.json()
        return response
    }
    return {};/* error */
}

ServicesUser.GetAllAssignment = async (Token) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/assignment/all`, {
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

ServicesUser.GetAssignmentByUserId = async (Token, id) => {//params:  token
    try {
        const Response = await fetch(`${BASE_URL}/assignment/${id}`, {
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


ServicesUser.DeleteAssignmentAllById = async (Token, user, rol) => {

    const Response = await fetch(`${BASE_URL}/assignment/del`, {
        method: "DELETE",
        headers: {
            Authorization: `Bearer ${Token}`,
            "Content-type": "application/json"
        },
        body: JSON.stringify({/* Convert the data to json */
            rol: `${rol}`,
            user: `${user}`
        })
    })
    if (Response.ok) {
        const response = await Response.json()
        return response
    }
    return {};/* error */
}

ServicesUser.DeleteAssignmentById = async (Token, id) => {

    const Response = await fetch(`${BASE_URL}/assignment/del/${id}`, {
        method: "DELETE",
        headers: {
            Authorization: `Bearer ${Token}`
        }
    })
    if (Response.ok) {
        const response = await Response.json()
        return response
    }
    return {};/* error */
}



//-------------------------------------------------------------

export default ServicesUser;/* Exporting services  */

//-------------------------------------------------------------

//Call routes for user

//Public Routes (no token needed) for user

// SingUp(true or false, "username", "pass","mail@sss.com",true or false);
//SingIn("username", "pass");


//-------------------------------------------------------------

//Private Routes (token needed) for user

//Get all users by page
//GetAllUsersPage("token", page, size);

//get all users
//GetAllUsers("token", role);

//get user by id
//GetUserById("token", id);

//Delete User
//DeleteUserId("token", id);

//Toggle Auth
//ToggleAuthUser("token", id);

//Toggle Active
//ToggleActiveUser("token", id);


//-------------------------------------------------------------
//Movement services
//AddMovement("token",id,movement,descrip);

//DeleteMovement("token",id);

//GetAllMovement("token");

//GetMovementByUserId("token",id);

//GetAllMovementPage("token",page,size);

//-------------------------------------------------------------

//Assignment services

//AddAssignment("token",rol,user);

//GetAllAssignment("token");

//GetAssignmentByUserId("token",id);

//DeleteAssignmentAllById("token",user,rol);

//DeleteAssignmentById("token",id);

//-------------------------------------------------------------

