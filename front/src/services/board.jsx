import axios from "axios";

export const getBoard = async () => {
  //const email = localStorage.getItem('email');
  const accessToken = localStorage.getItem('accessToken');
  const response = await axios.get(`http://localhost:8080/board?id=1`, {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${accessToken}`
    }
  });
  return response.data;
};

export const soldTicket = async (cell, userClient) => {
  const response = await axios.post(`http://localhost:8080/transaction`, {
    cell: cell,
    user: userClient
  });
  return response.data;
}