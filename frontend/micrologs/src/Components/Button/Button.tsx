import "./button.css";

type labelledInputProps = {
    label: string;
    // state: string;
    // setState: React.Dispatch<React.SetStateAction<T>>;
    className?: string;
    onClick?: React.MouseEventHandler<HTMLDivElement> | undefined;
};

const Button = (props: labelledInputProps) => {
    return (
        <div
            className={"button outline " + props.className}
            onClick={props.onClick}
        >
            {props.label}
        </div>
    );
};

export default Button;
