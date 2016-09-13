import React from 'react';
import RowsService from './RowsService';
import RowComponent from './RowComponent';

export default class Template extends React.Component{
  
  constructor() { 
    super();
    this.rowsService = new RowsService();
    this.state = { rows: [] };
    this.rowsService.getRows("http://localhost:8080/backend/resources/rows").
      then(r => this.setState({ rows: r })).
      then(r => console.log(r));
  }

 render(){
   return (
     <div>
       {
         this.state.rows.map(function (row) {
         return(  
             <RowComponent row={row}/>
         )
         })
       }  
       </div>
   )
 }

}
