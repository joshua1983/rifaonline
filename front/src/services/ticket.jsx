import axios from 'axios';

const getTicket = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8080/ticket?id=${id}`);
    return response.data;
  } catch (error) {
    console.error('Error fetching ticket:', error);
    throw error;
  }
};

export default getTicket;
