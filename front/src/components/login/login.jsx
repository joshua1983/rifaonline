import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import backLogin from '../../services/backLogin'

import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { Box } from '@mui/material';

function LoginComponent() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [emailError, setEmailError] = useState('');
    const [passwordError, setPasswordError] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate()
    const onButtonClick = () => {
        if (email.length === 0) {
            setEmailError('Email is required');
        }
        if (!/^[\w-.]+@([\w-]+\.)+[\w-]{2,4}$/.test(email)) {
            setEmailError('Please enter a valid email')
            return
        }
        if (password.length === 0) {
            setPasswordError('Password is required');
        }
        const loginRequest = {
            username: email,
            password: password
        }
        backLoginRequest(loginRequest)
    }

    const backLoginRequest = (loginRequest) => {
        setIsLoading(true)
        let response = backLogin(loginRequest)
        if (response != undefined) {
            navigate('/main')
        } else {
            setErrorMessage(response.data)
        }
        setIsLoading(false)
    }

    return (

        <Box component="form" noValidate autoComplete="off">
            <div className='mt-2'>
                <TextField margin='normal' variant="outlined" label="Email" type="email" value={email} onChange={(e) => setEmail(e.target.value)} />
            </div>
            <label>{emailError}</label>
            <div className='mt-2'>
                <TextField margin='normal' variant="outlined" label="Password" type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>
            <label>{passwordError}</label>
            <div className='mt-2'>
                <Button variant="contained" onClick={onButtonClick}>Entrar</Button>
            </div>
            {isLoading && <p className="mt-2 text-sm text-gray-500">Loading...</p>}
            <p className="mt-10 text-center text-sm text-gray-500">
                <a href="#" className="font-semibold leading-6 text-indigo-600 hover:text-indigo-500">Registrarse</a>
            </p>
            <p>
                {errorMessage}
            </p>
        </Box>
    )
}
export default LoginComponent