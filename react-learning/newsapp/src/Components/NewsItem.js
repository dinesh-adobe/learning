import React, { Component } from 'react'

export default class NewsItem extends Component {


    render() {

        let { title, description, imgUrl, newsURl,tagName } = this.props;

        return (

            <div className="my-3">
                <div className="card-body" >
                <div className="position-absolute top-0  translate-middle badge rounded-pill bg-danger" style={{left:'40%',top:-10, zIndex:1, color:'white'}}>
                        {tagName}
                    </div>
                    <img src={imgUrl} className="card-img-top" alt="..." />
                    
                    <div className="card-body">
                        <h5 className="card-title">{title}</h5>
                        
                        <p className="card-text">{description}</p>
                        <a href={newsURl} className="btn btn-sm btn-primary">Read More</a>
                    </div>
                    
                </div>
            </div>

        )
    }
}