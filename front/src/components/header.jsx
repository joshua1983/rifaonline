import React from 'react'
import { useNavigate, useLocation } from 'react-router-dom'
import { BottomNavigation, BottomNavigationAction } from '@mui/material'
import ExitToAppIcon from '@mui/icons-material/ExitToApp';

function Header() {
    const navigate = useNavigate()
    const location = useLocation()
    const email = localStorage.getItem('email')
    function logout() {
        localStorage.removeItem('accessToken')
        localStorage.removeItem('tokenType')
        localStorage.removeItem('email')
        navigate('/')
    }
    function isLogged() {
        return email !== null
    }

    function renderLogout() {
        if (isLogged()) {
            return (
                <BottomNavigationAction onClick={logout} label="Salir" icon={<ExitToAppIcon />} />
            )
        }
    }

    return (
        <BottomNavigation showLabels={true} >
            {renderLogout()}
        </BottomNavigation>
    )
}


//const HeaderComponent = withRouter(Header)
export default Header


