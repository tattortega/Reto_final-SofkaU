import { Course } from "./course";

export interface LearningRoute {
  id: string;
  name: string;
  description: string;
  level: number;
  course: Course;
  prerequisite: string;
}
