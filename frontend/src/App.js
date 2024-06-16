import './style/App.css';
import Nav from './componenets/Nav.jsx';
import ContentMainPage from './componenets/ContentMainPage.jsx';
import Footer from './componenets/Footer.jsx';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Login from './componenets/Login.jsx'; 
import Register from './componenets/Register.jsx';
import Contact from './componenets/Contact.jsx';
import Reportoire from './componenets/Repertoire.jsx';
import BuyTickets from './componenets/BuyTickets.jsx';
import Summary from './componenets/Summary.jsx';
import { AuthProvider } from './componenets/AuthContext';
import AboutUs from './componenets/AboutUs.jsx';

function App() {
  return (
    <AuthProvider>
      <Router>
        <div className="App">
            <Nav />
            <Switch>
              <Route exact path="/" component={ContentMainPage} />
              <Route path="/login" component={Login} />
              <Route path="/register" component={Register} />
              <Route path="/contact" component={Contact} />
              <Route path="/about" component={AboutUs} />
              <Route path="/Repertoire" component={Reportoire} />
              <Route path="/showtime/:hour" component={BuyTickets} />
              <Route path="/summary/:hour" component={Summary} />
            </Switch>
        </div>
      </Router>
    </AuthProvider>
  );
}

export default App;
