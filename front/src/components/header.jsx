import React from 'react'
import { Link } from 'react-router-dom'
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

    function renderLogout() {
        console.log(location.pathname)
        if (location.pathname !== '/' && email !== null) {
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


