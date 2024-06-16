
import "../style/Nav.css";
import React, { useContext, useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './AuthContext.jsx'; 

function Nav() {
    const { isLoggedIn, setIsLoggedIn } = useContext(AuthContext); 
    const [loggedInStatus, setLoggedInStatus] = useState(isLoggedIn);

    const handleLogout = () => {
        localStorage.removeItem('token');
        setIsLoggedIn(false);
    };

    useEffect(() => {
        setLoggedInStatus(isLoggedIn);
    }, [isLoggedIn]);

    return (
        <div className="nav-content">
            <div className="left-nav-side">
                <Link to="/">Cinema TCS</Link>
            </div>
            <div className="right-nav-side">
                <div className="option-nav">
                    <Link to="/repertoire">Repertoire</Link>
                </div>
                <div className="option-nav">
                    <Link to="/about">About us</Link>
                </div>
                <div className="option-nav">
                    <Link to="/contact">Contact</Link>
                </div>
                {loggedInStatus ? (
                    <div className="option-nav">
                        <button onClick={handleLogout} className="nav-button-log-out">Log out</button>
                    </div>
                ) : (
                    <>
                        <div className="option-nav">
                            <Link to="/login" className="nav-button">
                                Log in
                            </Link>
                        </div>
                        <div className="option-nav">
                            <Link to="/register" className="nav-button">
                                Register
                            </Link>
                        </div>
                    </>
                )}
            </div>
        </div>
    );
}

export default Nav;
