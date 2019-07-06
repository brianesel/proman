import axios from 'axios'
import CryptoJS from 'crypto-js'

const API_URL= 'http://localhost:1609'

class Auth {
    constructor() {
        this.isAuthenticated = false;
    }

    // login(cb) {
    //     return axios.get(`${API_URL}/api/auth/checkUserStatus`, {
    //         headers: {
    //             'Content-Type': OathInfo.contentType,
    //             'Authorization' : OathInfo.accessToken
    //         }
    //     })
    // }

    checkUserLoggedin() {
        return axios
        .post(`${API_URL}/api/auth/checkUserStatus`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization' : localStorage.getItem('userOathTokenType')+" "+ (CryptoJS.AES.decrypt((localStorage.getItem('accessTokenEncrypted')).toString(), 'somerandomsecretkey')).toString(CryptoJS.enc.Utf8)
            }
        })
        .then((response)=>{
            
            if(response.data===true || response.data ==="true") {
                this.isAuthenticated = true;
            } else {
                this.isAuthenticated = false;
            }
        })
    }
}
export default new Auth();