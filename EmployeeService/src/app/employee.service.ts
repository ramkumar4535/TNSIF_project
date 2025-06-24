import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  API="http://localhost:8080";
  public registerEmployee(employeeData: any)
  {
    return this.http.post(`${this.API}/employeeservice` , employeeData);
  }

  public getEmployees(){
    return this.http.get(`${this.API}/employeeservice`);
  }

  public deleteEmployee(employeeId:any){
    return this.http.delete(`${this.API}/employeeservice/${employeeId}`);
  }

  public updateEmployee(employee: any){
    return this.http.put(`${this.API}/employeeservice/${employee.eid}`, employee);
  }
  constructor(private http: HttpClient) { }
}
