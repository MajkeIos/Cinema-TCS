import React, { useEffect, useState } from 'react';
import { useHistory } from 'react-router-dom';
import '../style/MovieInReportoire.css';
import axios from 'axios';

const MovieInReportoire = (props) => {
    const history = useHistory();

    const handleClickButton = (hour, index) => {
        history.push({
            pathname: `/showtime/${hour}`,
            state: {
                movieName: props.name,
                screeningId: props.screeningId[index],
                numberOfColumns: props.numberOfColumns[index],
                numberOfRows: props.numberOfRows[index],
                bookedSeats: props.bookedSeats[index]
            }
        });
    };

    return (
        <div className="movie-container">
            <div className="movie-image">
                <a href=""><img src={props.imagePath} alt={props.name} /></a>
            </div>
            <div className="movie-info">
                <p>{props.name}</p>
                {props.availableHours.map((hour, index) => (
                    <button key={index} onClick={() => handleClickButton(hour, index)}>
                        {hour}
                    </button>
                ))}
            </div>
        </div>
    );
};


export default MovieInReportoire;
