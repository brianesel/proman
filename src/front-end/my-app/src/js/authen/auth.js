class Auth {
    constructor() {
        this.isAuthenticated = true;
    }

    login(cb) {
        return axios.get(`${API_URL}/api/auth/checkUserStatus`, {
            headers: {
                'Content-Type': OathInfo.contentType,
                'Authorization' : OathInfo.accessToken
            }
        })
    }
}