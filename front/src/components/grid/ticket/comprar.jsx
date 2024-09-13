import React from 'react'
import { Button } from '@mui/material'
function Comprar() {
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Comprar');
    }
  return (
    <form onSubmit={handleSubmit}>
      <Button variant="contained" color="success" type="submit">Comprar</Button>
    </form>
  )
}

export default Comprar 