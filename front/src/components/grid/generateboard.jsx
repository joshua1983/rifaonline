import { useState, useEffect } from 'react';
import { getBoard } from '../../services/board';
import { Grid2, Paper, Typography } from '@mui/material';
import Centro from './ticket/centro';
import { useNavigate } from 'react-router-dom';
function GenerateBoard() {
    const navigate = useNavigate();
    const [data, setBoard] = useState(null);
    useEffect(() => {
        getBoard().then(setBoard);
    }, []);
    if (!data) return <div>Cargando...</div>;
    if (data.board === null) return <div>No hay datos</div>;
    const loadBoleta = (item) => {
        navigate('/boleta', { state: { item } });
    }
    return (
        <>
            <Centro />
            <br />
            <Grid2 container spacing={2} sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', marginLeft: '10px' }}>
                {data.cells.map((item, index) => (
                    <Grid2 xs={6} key={index} >
                        <Paper elevation={3} sx={{ p: 1, height: '70%', backgroundColor: getStatusStyle(item.status) }} onClick={() => loadBoleta(item)}>
                            <Typography variant="h4" style={{ textAlign: 'center' }}>{item.numberCell}</Typography>
                            <Typography style={{ textAlign: 'center', fontFamily: 'Poppins, sans-serif', fontSize: '.7em', fontWeight: 'bold' }}>
                                {getTextStatus(item.status)}
                            </Typography>
                        </Paper>
                    </Grid2>
                ))}
            </Grid2>
            <br />


        </>
    );
}

function getTextStatus(status) {
    switch (status) {
        case 'OPEN':
            return 'Comprar!';
        case 'PAID':
            return 'Vendido!';
        case 'BLOCKED':
            return 'Reservado!';
    }
}

function getStatusStyle(status) {
    switch (status) {
        case 'OPEN':
            return { backgroundColor: '#00FF00' };
        case 'PAID':
            return { backgroundColor: '#b2bfdc' };
        case 'BLOCKED':
            return { backgroundColor: '#FF0000' };
        default:
            return { backgroundColor: '#00FF00' };
    }
}

export default GenerateBoard