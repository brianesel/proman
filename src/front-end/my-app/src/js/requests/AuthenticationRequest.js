import axios from 'axios'

const API_URL= 'http://localhost:1609'

class AuthenticationRequest {
    constructor() {
        this.isAuthenticated = false;
    }

    registerNewUser(userInfo) {
        return axios.post(`${API_URL}/api/auth/signup`, {
            username : userInfo.username,
            password : userInfo.password,
            email : userInfo.email,
            name : userInfo.name
        })
    }

    loginUser(userInfo) {
        return axios.post(`${API_URL}/api/auth/signin`,{
            usernameOrEmail : userInfo.userId,
            password : userInfo.password
        })
    }

    checkUserLoggedin(userInfo) {
        return axios.post(`${API_URL}/api/auth/checkUserStatus`, {
           accessToken: userInfo
        })
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