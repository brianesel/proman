import axios from 'axios'
import CryptoJS from 'crypto-js'

const API_URL= 'http://localhost:1609'

class UserRequest {
    getUserInfo(){
        return axios.get(`${API_URL}/user/info`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization' : localStorage.getItem('userOathTokenType')+" "+ (CryptoJS.AES.decrypt((localStorage.getItem('accessTokenEncrypted')).toString(), 'somerandomsecretkey')).toString(CryptoJS.enc.Utf8)
            }
        })
    }
}

export default new UserRequest()