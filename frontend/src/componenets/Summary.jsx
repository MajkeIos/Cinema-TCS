import { useLocation } from 'react-router-dom';
import '../style/Summary.css';
import axios from 'axios';

function Summary() {
    const location = useLocation();
    const { movieName, screeningId, regularNumber, reducedNumber, boughtPlacesIds } = location.state || {};    
    const regularPrice = 28;
    const reducedPrice = 18;

    const handlePayButton = async () => {
        const token = localStorage.getItem('token');
        if (!token) {
            console.error('Token not found.');
            return;
        }
    
        const username = localStorage.getItem('username');
    
        const screeningReservations = boughtPlacesIds.map(place => ({
            rowNumber: place.row,
            seatNumber: place.column,
            ticketPrice: regularPrice*regularNumber + reducedNumber*reducedPrice,
            ticketType: "regular"
        }));
    
        const requestBody = {
            username: username,
            screeningId: screeningId,
            screeningReservations: screeningReservations
        };
    
        console.log("Request Body: ", requestBody);
    
        axios.post('http://localhost:8080/v1/reservations', requestBody, {
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            console.log('Reservation created successfully:', response.data);
        })
        .catch(error => {
            console.error('Error creating reservation:', error);
        });

        const response = await axios.get('http://localhost:8080/v1/users/' + username, {
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        })

        await sendEmail(username, response.data.email, token)

        alert("Thank you for purchasing tickets. E-mail will be available on e-mail!")
        window.location.href = '/';
    };

    const sendEmail = async (username, email, token) => {
        const requestBodyForEmail = {
            message: `Then you ${username} for purchasing a ticket for ${movieName}!`,
            recipient: email
        }

        axios.post('http://localhost:8080/v1/email/sendemail', requestBodyForEmail, {
            headers: {
                Authorization: `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            console.log('Mail send successfully:', response.data);
        })
        .catch(error => {
            console.error('Error sending mail:', error);
        });
      };

    return (
        <div className="summary-container">
            <h1>Summary:</h1>
            <div className="values-box">
                <strong>Name:</strong> {movieName} <br></br>
                <strong>Regular ticket:</strong> {regularNumber}<br></br>
                <strong>Reduced ticket:</strong> {reducedNumber}<br></br>
                <strong>Total price:</strong> {regularNumber * regularPrice + reducedNumber * reducedPrice} PLN
                {boughtPlacesIds && boughtPlacesIds.map(place => (
                    <p key={`${place.row}-${place.column}`}>Row: {place.row}, Column: {place.column}</p>
                ))}
            </div>
            <button className="pay-button" onClick={handlePayButton}>Pay</button>
        </div>
    );
}

export default Summary;
