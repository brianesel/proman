import axios from 'axios'

const API_URL= 'http://localhost:1609'

class landingpagerequest {
    sendMessage(messagesContent){
        return axios.post(`${API_URL}/mail/sendtoMe`, {
            subject: messagesContent.mailSubject,
            text: "Sender name:"+ messagesContent.senderName + "from:"+ messagesContent.senderEmail + "Phone number" + messagesContent.phoneNumber + "Messages:" + messagesContent.message
        })
    }
}

export default new landingpagerequest()