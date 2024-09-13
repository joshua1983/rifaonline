import React from 'react'
import EtiquetaConLinea from './formItem';
const Derecha = ({numero}) => {
    const textStyle = {
        textAlign: 'center',
        fontFamily: 'Poppins, sans-serif',
        fontSize: '1em',
    };
    const pinkBackgroundStyle = {
        backgroundColor: 'pink',
        padding: '10px',
        borderRadius: '5px',
        marginTop: '10px',
        width: '94%',
    };
    const titleStyle = {
        fontFamily: 'Arvo, sans-serif',
        fontSize: '1.7em',
        display: 'block',
        color: 'white',
        textAlign: 'right',
        marginTop: '0',
        marginRight: '10px',
        marginBottom: '0',
    };
    return (
        <>
            <div style={textStyle}>EL SORTEO SE REALIZARÁ EL 27 DE SEPTIEMBRE CON LAS DOS ULTIMAS CIFRAS DE LA LOTERIA DE SANTANDER</div>
            <div style={pinkBackgroundStyle}>
                <h1 style={titleStyle}>#{numero}</h1>
                <EtiquetaConLinea label="Nombre: " content="Juan Perez" color="white" />
                <EtiquetaConLinea label="Correo: " content="juanperez@gmail.com" color="white" />
                <EtiquetaConLinea label="Teléfono: " content="1234567890" color="white" />
                <EtiquetaConLinea label="Dirección: " content="Calle 123, Ciudad 456, País 789" color="white" />
            </div>
            <div style={textStyle}>BOLETA SIN CANCELAR NO JUEGA</div>
        </>
    )
}

export default Derecha