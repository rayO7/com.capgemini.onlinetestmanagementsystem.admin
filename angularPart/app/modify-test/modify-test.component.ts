import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { Test } from '../Test';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modify-test',
  templateUrl: './modify-test.component.html',
  styleUrls: ['./modify-test.component.css']
})
export class ModifyTestComponent implements OnInit {

  testId:number
  topic:string
  totalMarks:number
  minMarks:number
  duration:number
  sTime:string
  eTime:string
  testList:Test

  constructor(private service:ConfigService, private router:Router) { }

  add()
  {
    this.topic=this.testList.topic
    this.totalMarks= this.testList.marks
    this.minMarks=this.testList.minMarks
    this.duration= this.testList.duration
    this.sTime=this.testList.startTime
    this.eTime=this.testList.endTime
    
    this.service.add("http://localhost:8080/test/addTest",new Test(this.testId, this.topic, this.totalMarks, this.minMarks, this.duration, this.sTime, this.eTime)).subscribe(data=>{
      alert(data)
      console.log(data)
    });
    this.router.navigate(['/SubjectListComponent'])
  }

  delete()
  {
    this.service.delete("http://localhost:8080/admin/delete?id="+this.testId).subscribe(data=>{
    this.testList=data
    //alert(this.testList)
    console.log(this.testList)
    })

    
  }

  ngOnInit(): void {
  }

}
