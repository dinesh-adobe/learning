import React, {useState} from 'react'



export default function Textform(props) {
  const [text, setText] = useState('Initial State Text');
  
  const handleUpClick = () =>{
    
    let newText =text.toUpperCase();
    setText(newText);
  }

  const handleOnChange = (event) => {
    
    setText(event.target.value);
  }
 // setText("new Text");
  
  return (
<>    <div className='conatiner'>
        <h2>{props.heading}</h2>
        <div className='mb-3 my-10'>
            <textarea value={text} onChange={handleOnChange} className="form-control" id="myBox" rows="3"></textarea>
        </div>
        <button  onClick={handleUpClick} className="btn btn-primary">Convert to Upper Case</button>
    
    </div>

    <div className="container">
        <h3>Your text summary</h3>
        <p> {text.split(" ").length} Words and {text.length} Characters </p>
        <p> { 0.008 *text.split(" ").length} minutes to read summary</p> 
    </div>
    </>
  )
}
