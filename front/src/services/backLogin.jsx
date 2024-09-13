import axios from 'axios';

const backLogin = async (requestlogin) => {
    try {
        const response = await axios.post('http://localhost:8080/login', requestlogin);
        const tokenResponse = {
            accessToken: response.data.accessToken,
            tokenType: response.data.tokenType
        }
        storeToken(tokenResponse, requestlogin.username);
        return tokenResponse;
    } catch (error) {
        console.error('Login failed:', error);
        throw error;
    }
};

function storeToken(tokenResponse, email) {
    localStorage.setItem('accessToken', tokenResponse.accessToken);
    localStorage.setItem('tokenType', tokenResponse.tokenType);
    localStorage.setItem('email', email);
}


export default backLogin;
