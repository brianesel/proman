import axios from 'axios'
import CryptoJS from 'crypto-js'
import { createMemoryHistory } from 'history';

const API_URL= 'http://localhost:1609'

class AuthenticationRequest {
    constructor() {
        this.isAuthenticated = false;
    }

    logout() {
        localStorage.removeItem('accessTokenEncrypted');
        this.isAuthenticated = false;
    }

    registerNewUser(userInfo) {
        return axios.post(`${API_URL}/api/auth/signup`, {
            username : userInfo.username,
            password : userInfo.password,
            email : userInfo.email,
            name : userInfo.name,
            phoneNumber: userInfo.phoneNumber,
            location: userInfo.location,
            degree: userInfo.degree
        })
    }

    loginUser(userInfo) {
        return axios.post(`${API_URL}/api/auth/signin`,{
            usernameOrEmail : userInfo.userId,
            password : userInfo.password
        })
    }

    checkUserLoggedin(props,path) {
        
        if (localStorage.getItem('accessTokenEncrypted') !== null && localStorage.getItem('accessTokenEncrypted') !== undefined && localStorage.getItem('userOathTokenType') !==null && localStorage.getItem('userOathTokenType') !== undefined){
            return axios
            .get(`${API_URL}/api/auth/checkUserStatus`, {
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8',
                    'Authorization' : localStorage.getItem('userOathTokenType')+" "+ (CryptoJS.AES.decrypt((localStorage.getItem('accessTokenEncrypted')).toString(), 'somerandomsecretkey')).toString(CryptoJS.enc.Utf8)
                }
            })
            .then((response)=>{
                if(response.data===true || response.data ==="true") {
                    this.isAuthenticated = true;
                    if(props !== null && props !== undefined ){    
                        const { history } = props;
                        history.push(path);
                    }else {
                        const history = createMemoryHistory();
                        history.push(path);
                    }
                } else {
                    this.isAuthenticated = false;
                }
            })
        }
        else {
            return false;
        }
    }

    getUserInfo(OathInfo) {
        return axios.get(`${API_URL}/api/user`, {
            headers: {
                'Content-Type': OathInfo.contentType,
                'Authorization' : OathInfo.accessToken
            }
        })
    }

}

export default new AuthenticationRequest()