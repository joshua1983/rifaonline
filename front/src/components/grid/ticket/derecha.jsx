import React from 'react'
import EtiquetaConLinea from './labelItem';
import PropTypes from 'prop-types';
const Derecha = ({ numero, formData }) => {
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
                <EtiquetaConLinea label="Nombre: " content={formData.nombre} color="white" />
                <EtiquetaConLinea label="Teléfono: " content={formData.telefono} color="white" />
                <EtiquetaConLinea label="Dirección: " content={formData.direccion} color="white" />
            </div>
            <div style={textStyle}>BOLETA SIN CANCELAR NO JUEGA</div>
        </>
    )
}

Derecha.propTypes = {
    numero: PropTypes.number.isRequired,
    formData: PropTypes.object.isRequired
}

export default Derecha