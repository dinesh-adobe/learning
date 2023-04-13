import React, { Component } from 'react'
import NewsItem from './NewsItem'
import Spinner from './Spinner';

export default class Newsapp extends Component {
    articles = [
        {
            "source": {
                "id": "the-washington-post",
                "name": "The Washington Post"
            },
            "author": "Joshua Partlow",
            "title": "Biden administration review of Colorado River highlights tough choices - The Washington Post",
            "description": "The federal review lays out the painful choices facing the American West after a two-decade drought and chronic overuse have left crucial lakes — the water supply for tens of millions of people — dangerously diminished.",
            "url": "https://www.washingtonpost.com/climate-environment/2023/04/11/colorado-river-biden-review/",
            "urlToImage": "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/JUOQ2DH325DDDSBCTBV4EPH3KY_size-normalized.jpg&w=1440",
            "publishedAt": "2023-04-11T19:55:37Z",
            "content": "Comment on this story\r\nComment\r\nThe Biden administration on Tuesday published its environmental review of operations at the Colorado Rivers major reservoirs, a document that lays out the painful choi… [+7501 chars]"
        },
        {
            "source": {
                "id": "fox-news",
                "name": "Fox News"
            },
            "author": "Julia Musto",
            "title": "Weight loss in older adults associated with risk of death, study shows - Fox News",
            "description": "A new study that followed healthy older Australian and U.S. adults concluded that weight loss may increase their risk of death, including life-limiting conditions.",
            "url": "https://www.foxnews.com/health/weight-loss-older-adults-associated-risk-death",
            "urlToImage": "https://static.foxnews.com/foxnews.com/content/uploads/2023/04/man-weight-tape-measure.jpg",
            "publishedAt": "2023-04-11T19:44:00Z",
            "content": "Weight loss in older adults may increase their risk of death, according to new research. \r\nA cohort study published in the journal JAMA Network Open Monday looked at more than 16,000 adults in the U.… [+2157 chars]"
        }
        
    ];


    constructor() {
        super();
        this.state = {
            articles: this.articles,
            loading: false,
            page: 1
        }
    }

    // url =`https://newsapi.org/v2/top-headlines?country=us&apiKey=f4454e125c634509bda2c7c843122043&page=${this.state.page}`;

    async componentDidMount(){
        let url =`https://newsapi.org/v2/top-headlines?country=us&category=${this.props.category}&apiKey=f4454e125c634509bda2c7c843122043&page=${this.state.page}&pageSize=${this.props.pageSize}`;
        let data = await fetch(url);
        let parseData = await data.json()
        this.setState({articles: parseData.articles, totalResults:parseData.totalResults});
    }

    handleNext = async () =>{
        console.log("next"); 
        if(this.state.page + 1 > Math.ceil(this.state.totalResults/10)){
            
        }
        else{
            let url =`https://newsapi.org/v2/top-headlines?country=us&category=${this.props.category}&apiKey=f4454e125c634509bda2c7c843122043&page=${this.state.page+1}&pageSize=${this.props.pageSize}`;
             this.setState({loading:true}); 
        let data = await fetch(url);
        let parseData = await data.json()
        this.setState({
            articles: parseData.articles,
            page : this.state.page + 1,
            loading:false
        });
        }
    


        
    }

    handlePrevious = async () => {
        console.log("previous");
        let url =`https://newsapi.org/v2/top-headlines?country=us&category=${this.props.category}&apiKey=f4454e125c634509bda2c7c843122043&page=${this.state.page-1}&pageSize=${this.props.pageSize}`;
        this.setState({loading:true});
        this.setState.page = this.state.page-1;
        let data = await fetch(url);
        let parseData = await data.json()
        this.setState({
            articles: parseData.articles,
            page : this.state.page -1,
            loading:false
        });
    }

    render() {

       
        return (

            <div className="container my-3">
                <h2 className="text-center"> News App {this.props.category}</h2>
                { this.state.loading && <Spinner/>}
                <div className="row">
                {this.state.articles.map((element) => {
                    return  <div className="col-md-4" key={element.url}>
                    <NewsItem title={element.title} description={element.description} imgUrl={element.urlToImage} newsURl={element.url}  tagName={element.source.name} />
                </div>
                })}
                </div>

                <div className="d-flex justify-content-around">
                <button type="button" disabled={this.state.page<=1} className="btn btn-outline-secondary" onClick={this.handlePrevious}> &larr; Previous</button>
                <button type="button" disabled={this.state.page + 1 > Math.ceil(this.state.totalResults/10)} className="btn btn-outline-secondary" onClick={this.handleNext}>Next &rarr;</button>
                </div>

            </div>


        )
    }
}
