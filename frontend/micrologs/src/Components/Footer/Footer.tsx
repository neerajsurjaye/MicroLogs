import { BsGithub } from "react-icons/bs";
import "./footer.css";

const Footer = () => {
    return (
        <div className="footer outline">
            <div className="footer-hero">
                <div className="footer-text-box">M</div>
                <div className="footer-text-box">I</div>
                <div className="footer-text-box">C</div>
                <div className="footer-text-box">R</div>
                <div className="footer-text-box">O</div>
                <div className="footer-text-box">L</div>
                <div className="footer-text-box">O</div>
                <div className="footer-text-box">G</div>
                <div className="footer-text-box">S</div>
            </div>

            <div className="footer-link">
                <a href="https://github.com/neerajsurjaye/MicroLogs">
                    <BsGithub></BsGithub> Github
                </a>
            </div>
        </div>
    );
};

export default Footer;
