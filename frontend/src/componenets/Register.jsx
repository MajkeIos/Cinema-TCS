import React, { useState, useContext } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';
import '../style/Login.css';
import { AuthContext } from './AuthContext'; 

function Register() {
    const { setIsLoggedIn } = useContext(AuthContext); 
    const history = useHistory(); 

    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: ''
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        try {
            const response = await axios.post('http://localhost:8080/v1/auth/register', formData);
            console.log("TOKEN")
            console.log(response.data);
            localStorage.setItem('token', response.data.token);
            
            setIsLoggedIn(true);
            history.push('/');
        } catch (error) {
            alert("A user with such data already exists")
            console.error('Wystąpił błąd podczas wysyłania żądania:', error);
        }
    };

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Register</h2>
                <form onSubmit={handleSubmit}>
                    Login <br/> <input type="text" name="username" onChange={handleChange} /><br/>
                    Mail <br/> <input type="text" name="email" onChange={handleChange} /><br/>
                    Password <br/> <input className="passwordType" type="password" name="password" onChange={handleChange} /> <br></br>
                    <button type="submit" className="big-log-in-button">Register</button>
                </form>
            </div>
        </div>
    );
}

export default Register;
