import React from 'react';



export default class RowComponent extends React.Component { 

    render() { 
        return (
            <section>
                <div key={this.props.row.first}>Component: {this.props.row.second}</div>
            </section>    
        );

    }

}