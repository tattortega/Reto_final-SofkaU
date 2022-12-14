import { Course } from "./course";

export interface LearningRoute {
  id: string;
  name: string;
  description: string;
  routes: Route[]
}

export interface Route {
  level: number;
  courseId: Course;
  precourseId: Course;
}
