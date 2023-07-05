const BASE_URL = "http://localhost:8080/mail"

const ServicesMail = {};

//send email
ServicesMail.SendMail = async (Token, from,to,subject,body) => {
    try {
        const Response = await fetch(`${BASE_URL}/send-email`, {
            method: "POST",
            headers: {
                Authorization: `Bearer ${Token}`,
                "content-type": "application/json"
            },
            body: JSON.stringify({/* Convert the data to json */
                from: `${from}`,
                to: `${to}`,
                subject: `${subject}`,
                body: `${body}`
            })
        });
        const data = await Response.json();
        console.log(data);
        return data;
    } catch (error) {
        console.log(error);
    }
};



export default ServicesMail;/* Exporting services  */

//SendMail(from,to,subject,body)todos son string los primeros dos son correos