# AWS-taskMaster
- TaskMaster allows to create new tasks, add new users to the tasks, make changes to the tasks (state of completion), records
  the history of the changes, and change users assiggned to the task.
  
###### Deployment
  * [Link to AWS Task-Mast3er](http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1/tasks)
  
###### How to Test/Use
  * Use this route with "GET" to get all the tasks: "http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1/tasks"
  * Use this route with "POST" to get all the tasks: "http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1/tasks" PARAMS = { "title" : "titlename",
                                                      "description" : "new description",
                                                      "assignee" : "new assignee"
                                                      }
  * Use this route with "GET" to get all the tasks associated with the user: "http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1//users/{name}/tasks"
  * Use this route with "PUT" to change the state of task: "http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1/tasks/{id}/state"
  * Use this route with "PUT" to change the user to the task: "http://taskmaster-manish.us-west-2.elasticbeanstalk.com/taskmaster/v1/tasks/{id}/assign/assignee"
  

#### Issues with the deployment:
  * A learning lesson, where it became difficult to retrieve the history of changes because an empty constructor was not created.
  * Trying to update the table before it was created. 
