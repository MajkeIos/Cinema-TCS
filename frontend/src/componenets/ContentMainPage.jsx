import '../style/ContentMainPage.css';
import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from './AuthContext';
import Footer from './Footer';

function ContentMainPage() {
    const { isLoggedIn } = useContext(AuthContext); // Pobierz stan autoryzacji

    return (
        <div className="container-main-page">
            <div className="description-main-page">
                Step into the world of cinematic wonders at Cinama, where each visit promises an unforgettable experience.
                Our modern theaters boast the latest blockbusters, timeless classics, and captivating indie films, ensuring there's something for every movie lover.
            </div>
            <div className="images-on-main-page">
                <img src="images/czlowiek.jpg" alt="czlowiek-kotry-poznal-nieskonczonosc" />
                <img src="images/dune2.jpg" alt="dune2" />
            </div>
            <div className="images-description">
                These two films are the top favorites at our cinema, drawing the largest audiences.
            </div>
            <div className="second-description-main-page">
                Don't wait and create an account on our website! Choose a movie and visit our cinema!<br /> <br />
                {!isLoggedIn && (
                    <Link to="/register" className="big-sign-in-button">
                        Join Us!
                    </Link>
                )}
            </div>
        </div>
    );
}

export default ContentMainPage;
