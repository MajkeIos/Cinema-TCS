import React, { useState } from 'react';
import { useParams, useLocation, useHistory } from 'react-router-dom';
import '../style/BuyTickets.css';

function BuyTickets() {
    const { hour } = useParams();
    const location = useLocation();
    const history = useHistory();

    const { movieName, screeningId ,numberOfColumns, numberOfRows, bookedSeats } = location.state || {};

    const [counter, setCounter] = useState(0);
    const [regularTicketCount, setRegularTicketCount] = useState(0);
    const [reducedTicketCount, setReducedTicketCount] = useState(0);
    const [boughtPlacesIds, setBoughtPlacesIds] = useState([]);

    const resetAllSeats = () => {
        for (let i = 0; i < numberOfRows; i++) {
            for (let j = 0; j < numberOfColumns; j++) {
                const buttonId = `${i}-${j}`;
                const button = document.getElementById(buttonId);
                if (button && button.className === "reserved-place") {
                    button.className = "free-place";
                }
            }
        }
        setBoughtPlacesIds([]);
    };

    const changeButtonColor = (row, column) => {
        const buttonId = `${row}-${column}`;
        const button = document.getElementById(buttonId);
        const seat = { row, column };
        if (button) {
            const classButtonName = button.className;
            if (classButtonName === "free-place" && counter !== 0) {
                button.className = "reserved-place";
                setCounter(counter - 1);
                setBoughtPlacesIds([...boughtPlacesIds, seat]);
            } else if (classButtonName === "reserved-place") {
                button.className = "free-place";
                setCounter(counter + 1);
                setBoughtPlacesIds(boughtPlacesIds.filter(s => !(s.row === row && s.column === column)));
            }
        }
    };

    const handleReservePlace = (row, column) => {
        changeButtonColor(row, column);
    };

    const handleRegularTicketChange = (event) => {
        const value = parseInt(event.target.value);
        setRegularTicketCount(value);
        resetAllSeats();
        updateCounter(value, reducedTicketCount);
    };

    const handleReducedTicketChange = (event) => {
        const value = parseInt(event.target.value);
        setReducedTicketCount(value);
        resetAllSeats();
        updateCounter(regularTicketCount, value);
    };

    const updateCounter = (regular, reduced) => {
        const totalTickets = regular + reduced;
        setCounter(totalTickets);
    };
    
    const drawCinemaHall = () => {
        console.log("Booked seats:", bookedSeats);
    
        const cinemaRows = [];
        for (let i = 0; i < numberOfRows; i++) {
            const seats = [];
            for (let j = 0; j < numberOfColumns; j++) {
                const isBooked = bookedSeats?.some(seat => {
                    const match = seat.rowNumber === i && seat.seatNumber === j;
                    if (match) console.log(`Seat at row ${i}, column ${j} is booked`);
                    return match;
                });
                const className = isBooked ? "booked-place" : "free-place";
                
                seats.push(
                    <button
                        key={j}
                        id={`${i}-${j}`}
                        className={className}
                        onClick={() => !isBooked && handleReservePlace(i, j)}
                    ></button>
                );
            }
            cinemaRows.push(<div key={i} className="cinema-row">{seats}</div>);
        }
        return cinemaRows;
    };
    
    

    const handleBuyTickets = () => {
        if (counter !== 0) {
            alert("Please, choose all seats!");
        } else {
            console.log("My bought places: ", boughtPlacesIds);
            history.push({
                pathname: `/summary/${hour}`,
                state: { 
                    movieName: movieName,
                    screeningId: screeningId,
                    regularNumber: regularTicketCount,
                    reducedNumber: reducedTicketCount,
                    boughtPlacesIds: boughtPlacesIds
                }
            });
        }
    };

    return (
        <div className="buy-ticket-content">
            <div className="set-ticket-container">
                <div className="set-ticket-number">
                    Regular ticket
                    <select value={regularTicketCount} onChange={handleRegularTicketChange}>
                        {[...Array(11).keys()].map(number => (
                            <option key={number} value={number}>{number}</option>
                        ))}
                    </select>
                </div>
                <div className="set-ticket-number">
                    Reduced ticket
                    <select value={reducedTicketCount} onChange={handleReducedTicketChange}>
                        {[...Array(11).keys()].map(number => (
                            <option key={number} value={number}>{number}</option>
                        ))}
                    </select>
                </div>
            </div>
            <div className="cinema-hall-container">
                <div className="screen"></div>
                <div className="current-hall">
                    {drawCinemaHall()}
                </div>
            </div>
            <div className="final-container">
                <button onClick={handleBuyTickets}>Buy</button>
            </div>
        </div>
    );
}

export default BuyTickets;
