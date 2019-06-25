class Auth {
    constructor() {
        this.isAuthenticated = false;
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