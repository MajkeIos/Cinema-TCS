import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../style/Reportoire.css';
import MovieInReportoire from './MovieInReportoire';

function Repertoire() {
    const [selectedDay, setSelectedDay] = useState('');
    const [movies, setMovies] = useState([]);
    const [start, setStart] = useState("");
    const [end, setEnd] = useState("");
    const [initialDayIndex, setInitialDayIndex] = useState(new Date().getDay());
    const [realStartDay, setRealStartDay] = useState("");
    const [realEndDay, setRealEndDay] = useState("");

    const fetchMovies = async () => {
        console.log("START: " + start + " " + end)
        try {
            const token = localStorage.getItem('token');
            if (!token) {
                console.error('Token not found.');
                return;
            }
            // console.log('Fetching movies with token:', token);

            const response = await axios.get('http://localhost:8080/v1/screenings', {
                params: {
                    start: start,
                    end: end
                },
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            setMovies(response.data);
            //console.log(response.data);
        } catch (error) {
            // console.error('Error fetching movies:', error);
        }
    };

    const prepareCurrentDate = () => {
        const today = new Date();
        const year = today.getFullYear();
        const month = String(today.getMonth() + 1).padStart(2, '0');
        const day = String(today.getDate()).padStart(2, '0');
        var hours = '00';
        var minutes = '00';
        var seconds = '00';
        const startDate = `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
        hours = '23';
        minutes = '59';
        seconds = '59';
        const endDate = `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
        setRealStartDay(startDate)
        setRealEndDay(endDate)
        setStart(startDate)
        setEnd(endDate)
    }

    useEffect(() => {
        prepareCurrentDate();
    }, []);

    useEffect(() => {
        if(start !== "") {
            fetchMovies();
        }
    }, [start]);

    const logCurrentDay = () => {
        const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        const currentDate = new Date();
        const currentDay = days[currentDate.getDay()];
        return currentDay;
    }

    useEffect(() => {
        setSelectedDay(logCurrentDay());
    }, []);

    function addDaysToDate(dateString, days) {
        const date = new Date(dateString);
        date.setUTCDate(date.getUTCDate() + days + 1);
        return date.toISOString().split('T')[0] + 'T00:00:00';
    }

    const handleDayClick = (day, adjustedIndex) => {
        setSelectedDay(day);
        const startDayIndex = initialDayIndex;
        let different = 0;

        if (adjustedIndex >= startDayIndex) {
            different = adjustedIndex - startDayIndex;
        } else {
            different = 7 - startDayIndex + adjustedIndex;
        }
        
        const currentStart = addDaysToDate(realStartDay, different);
        const currentEnd = addDaysToDate(realEndDay, different);
        setStart(currentStart);
        setEnd(currentEnd);
    };

    const getAvailableHours = (timestamp) => {
        const date = new Date(timestamp);
        const hour = date.getHours();
        return `${hour}:00`;
    }

    const renderDayOptions = () => {
        const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
        const startDayIndex = initialDayIndex;
        return days.map((day, index) => {
            const adjustedIndex = (startDayIndex + index) % 7;
            const isSelected = selectedDay === days[adjustedIndex];
            return (
                <p
                    key={index}
                    style={{ color: isSelected ? '#db0000' : '' }}
                    onClick={() => handleDayClick(days[adjustedIndex], adjustedIndex)}
                >
                    {days[adjustedIndex]}
                </p>
            );
        });
    }

    const organizeMoviesByTitle = (movies) => {
        const moviesByTitle = {};
    
        movies.forEach(movie => {
            const title = movie.movie.title;
            const showtime = getAvailableHours(movie.timestamp);
            if (!moviesByTitle[title]) {
                moviesByTitle[title] = {
                    title: title,
                    screeningId: [],
                    imagePath: "images/" + title + ".jpg",
                    availableHours: [],
                    numberOfRows: [],
                    numberOfColumns: [],
                    bookedSeats: []
                };
            }
            moviesByTitle[title].screeningId.push(movie.screeningId);
            moviesByTitle[title].availableHours.push(showtime);
            moviesByTitle[title].numberOfRows.push(movie.screen.numberOfRows);
            moviesByTitle[title].numberOfColumns.push(movie.screen.numberOfColumns);
            moviesByTitle[title].bookedSeats.push(movie.screeningReservations);
        });

        return moviesByTitle;
    }
    

    const organizedMovies = organizeMoviesByTitle(movies);

    return (
        <div className="repertoire-container">
            <div className="days-bar">
                <p>Repertoire of cinema</p>
                <div className="available-days-bar">
                    {renderDayOptions()}
                </div>
            </div>
            <div className="available-movies">
                {Object.keys(organizedMovies).map((title, index) => (
                    <MovieInReportoire
                        key={index}
                        name={organizedMovies[title].title}
                        imagePath={organizedMovies[title].imagePath}
                        availableHours={organizedMovies[title].availableHours}
                        numberOfRows={organizedMovies[title].numberOfRows}
                        numberOfColumns={organizedMovies[title].numberOfColumns}
                        bookedSeats={organizedMovies[title].bookedSeats}
                        screeningId={organizedMovies[title].screeningId}
                    />
                ))}
            </div>
        </div>
    );
}

export default Repertoire;
