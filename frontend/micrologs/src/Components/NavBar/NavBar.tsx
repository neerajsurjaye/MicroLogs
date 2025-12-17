import { Link } from "react-router";
import "./navbar.css";

const NavBar = () => {
    return (
        <div className="navbar outline">
            <div className="logo">
                <Link to={"/"}>Logo</Link>
            </div>

            <div className="nav-buttons">
                <div className="btn">
                    <Link to={"/auth"}>Auth</Link>
                </div>

                <div className="btn">btn</div>
            </div>
        </div>
    );
};

export default NavBar;
