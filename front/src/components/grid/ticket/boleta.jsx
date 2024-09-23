import React from 'react'
import { useLocation } from 'react-router-dom';
import Izquierda from './izquierda'
import Centro from './centro'
import Derecha from './derecha'
import Comprar from './comprar'
import { useState } from 'react'
import { Button } from '@mui/material'
import { useNavigate } from 'react-router-dom'
const Boleta = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const { item } = location.state;
    const [formData, setFormData] = useState({
        nombre: '',
        correo: '',
        telefono: '',
        direccion: ''
    });
    const handleChange = (data) => {
        setFormData(data);
    }
    const lineStyle = {
        marginTop: '20px',
        width: '100%',
        height: '2px',
        backgroundColor: 'pink',
        backgroundImage: 'linear-gradient(to right, pink, white)',
        backgroundSize: '20px 2px',
        backgroundRepeat: 'repeat-x'

    };
    const handleVolver = () => {
        navigate(`/main`);
    }
    
    return (
        <div>
            <Comprar boleta={item} formData={formData} />
            <Button onClick={handleVolver}>Volver</Button>
            <Izquierda item={item} onFormDataChange={handleChange} />
            <div style={lineStyle} />
            <Centro />
            <div style={lineStyle} />
            <Derecha numero={item.numberCell} formData={formData} />
        </div>
    )
}

export default Boleta