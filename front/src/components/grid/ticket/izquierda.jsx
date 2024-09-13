import React from 'react'
import EtiquetaConLinea from './formItem';

const Izquierda = ({numero}) => {
    const dividerStyle = {
        width: '100%',
        height: '2px',
        backgroundColor: 'pink'
    };
    const titleStyle = {
        fontSize: '3em',
        fontWeight: 'bold',
        color: 'pink',
        textAlign: 'center',
        fontFamily: 'Poppins, sans-serif'
    };
    return (
        <div>
            <h1 style={titleStyle}>#{numero}</h1>
            <div style={dividerStyle} />
            <br />
            <EtiquetaConLinea label="Nombre: " content="Juan Perez" color="pink" colorContent="black" />
            <EtiquetaConLinea label="Correo: " content="juanperez@gmail.com" color="pink" colorContent="black" />
            <EtiquetaConLinea label="Teléfono: " content="1234567890" color="pink" colorContent="black" />
            <EtiquetaConLinea label="Dirección: " content="Calle 123, Ciudad 456, País 789" color="pink" colorContent="black" />
        </div>
    )
}

export default Izquierda