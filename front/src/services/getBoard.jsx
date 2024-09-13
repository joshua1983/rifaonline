import axios from "axios";

export const getBoard = async () => {
  //const email = localStorage.getItem('email');
  const accessToken = localStorage.getItem('accessToken');
  const response = await axios.get(`http://localhost:8080/board?email=josue.barrios@gmail.com`, {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${accessToken}`
    }
  });
  return response.data;
};
