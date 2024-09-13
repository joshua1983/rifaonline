import React from 'react'
import ImageWithCircle from './imgCircle';
const Centro = () => {

    const titleStyle = {
        fontFamily: 'Arvo, sans-serif',
        fontSize: '1.7em',
        display: 'block',
        color: 'pink'
    };
    const dataBoxStyle = {
        marginTop: '10px',
        width: '100%',
        height: '70px',
        backgroundColor: 'pink',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        color: 'white',
        fontWeight: 'bold',
        fontSize: '1.5em',
        fontFamily: 'Poppins, sans-serif'
    };
    const labelStyle = {
        fontFamily: 'Poppins, sans-serif',
        fontSize: '0.5em',
        display: 'block',
        color: 'white'
    };
    const imageSrc = '../../../public/art/sancho.jpeg';
    const circleText = '$5000';
    return (
        <div>
            <h1 style={titleStyle}>RIFA DE UNA OBRA DE ARTE</h1>
            <ImageWithCircle imageSrc={imageSrc} circleText={circleText} />
            <div style={dataBoxStyle}>
                <div style={{ width: '90%', textAlign: 'left' }}>
                    <label style={labelStyle}>Autor: ROSA CATALINA BARRIOS BARRERA</label>
                    <label style={labelStyle}>Titulo de la obra: SANCHO PANZA</label>
                    <label style={labelStyle}>Técnica: OLEO A LA ESPATULA</label>
                </div>
            </div>
        </div>
    )
}

export default Centro