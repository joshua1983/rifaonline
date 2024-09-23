import React, { useState } from 'react';
import PropTypes from 'prop-types';

const Izquierda = ({ item, onFormDataChange }) => {
    const [inputValues, setInputValues] = useState({
        nombre: '',
        correo: '',
        telefono: '',
        direccion: ''
    });
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
    const fontStyleControl = {
        fontFamily: 'Poppins, sans-serif',
        fontSize: '1.2em',
        display: 'block',
        color: 'pink'
    };
    const contentStyleControl = {
        fontFamily: 'Poppins, sans-serif',
        fontSize: '1.2em',
        display: 'block',
        color: 'black',
        width: '98%',
        height: '19px',
        marginTop: '5px'
    };
    const handleChange = (e) => {
        setInputValues({ ...inputValues, [e.target.name]: e.target.value });
        onFormDataChange(inputValues);
    }
    return (
        <div>
            <h1 style={titleStyle}>#{item.numberCell}</h1>
            <div style={dividerStyle} />
            <br />

            <div style={{ textAlign: 'left' }}>
                <label style={fontStyleControl}>Nombre</label>
                <input type='text' style={contentStyleControl} onChange={handleChange} name='nombre' value={inputValues.nombre}></input>
                <div style={{ width: '100%', height: '2px', backgroundColor: 'pink', marginTop: '5px' }} />
            </div>
            <div style={{ textAlign: 'left' }}>
                <label style={fontStyleControl}>Direccion</label>
                <input type='text' style={contentStyleControl} onChange={handleChange} name='direccion' value={inputValues.direccion}></input>
                <div style={{ width: '100%', height: '2px', backgroundColor: 'pink', marginTop: '5px' }} />
            </div>
            <div style={{ textAlign: 'left' }}>
                <label style={fontStyleControl}>Telefono</label>
                <input type='text' style={contentStyleControl} onChange={handleChange} name='telefono' value={inputValues.telefono}></input>
                <div style={{ width: '100%', height: '2px', backgroundColor: 'pink', marginTop: '5px' }} />
            </div>

        </div>
    )
}

Izquierda.propTypes = {
    item: PropTypes.object.isRequired,
    onFormDataChange: PropTypes.func.isRequired
}

export default Izquierda