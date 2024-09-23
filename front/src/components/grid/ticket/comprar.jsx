import React from 'react'
import { Button } from '@mui/material'
import Swal from 'sweetalert2'
import PropTypes from 'prop-types'
import { useNavigate } from 'react-router-dom'
import { soldTicket } from '../../../services/board'
function Comprar({ boleta, formData }) {
    const navigate = useNavigate();
    const handleSubmit = (e) => {
        e.preventDefault();

        const clientData = {
            name: formData.nombre,
            phone: formData.telefono,
            address: formData.direccion
        }

        soldTicket(boleta, clientData);

        Swal.fire({
            title: 'Comprado!',
            text: 'La boleta ha sido comprada',
            icon: 'success',
            confirmButtonText: 'Cool'
        })
        
        navigate(`/boleta`, { state: { item: boleta } });
    }
    return (
        <form onSubmit={handleSubmit}>
            <Button variant="contained" color="success" type="submit">Comprar</Button>
        </form>
    )
}

Comprar.propTypes = {
    boleta: PropTypes.object.isRequired,
    formData: PropTypes.object.isRequired
}

export default Comprar 