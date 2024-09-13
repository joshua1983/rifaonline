import React from 'react'
import Izquierda from './izquierda'
import Centro from './centro'
import Derecha from './derecha'
import Comprar from './comprar'
const Boleta = ({numero}) => {
    const lineStyle = {
        marginTop: '20px',
        width: '100%',
        height: '2px',
        backgroundColor: 'pink',
        backgroundImage: 'linear-gradient(to right, pink, white)',
        backgroundSize: '20px 2px',
        backgroundRepeat: 'repeat-x'

    };
    return (
        <div>
            <Izquierda numero={numero} />
            <div style={lineStyle} />
            <Centro />
            <div style={lineStyle} />
            <Derecha numero={numero} />
            <Comprar />
        </div>
    )
}

export default Boleta