import React, { useState, useContext } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router-dom';
import '../style/Login.css';
import { AuthContext } from './AuthContext';

function Login() {
    const { setIsLoggedIn } = useContext(AuthContext);
    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });
    const history = useHistory();

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        
        try {
            const response = await axios.post('http://localhost:8080/v1/auth/authenticate', formData);
            console.log(response.data);
            localStorage.setItem('token', response.data.token);
            localStorage.setItem('username', formData.username)
            setIsLoggedIn(true);
            history.push('/');
        } catch (error) {
            alert("Incorrect login or password")
        }
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2>Login</h2>
                <form onSubmit={handleSubmit}>
                    Login <br/> 
                    <input type="text" className="input-text" name="username" onChange={handleChange} value={formData.username} /><br/>
                    Password <br/> 
                    <input type="password" name="password" className="input-text" onChange={handleChange} value={formData.password} /><br/>
                    <button type="submit" className="big-log-in-button">Login</button>
                </form>
            </div>
        </div>
    );
}

export default Login;
