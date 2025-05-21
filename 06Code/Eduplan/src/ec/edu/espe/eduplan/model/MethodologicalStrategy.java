    package ec.edu.espe.eduplan.model;

    import java.util.ArrayList;

    /**
     *
     * @author SoftCrafters
     */

    public class MethodologicalStrategy {

        //Attributes
        private String initialActivities;
        private ArrayList<String> listOfStrategies;

        //Contructor

        public MethodologicalStrategy() {
        }

        public MethodologicalStrategy(String initialActivities, ArrayList<String> listOfStrategies) {
            this.initialActivities = initialActivities;
            this.listOfStrategies = listOfStrategies;
        }

        //toString

        @Override
        public String toString() {
            return initialActivities + listOfStrategies;
        }

        //Getters and Setters

        public String getInitialActivities() {
            return initialActivities;
        }

        public void setInitialActivities(String initialActivities) {
            this.initialActivities = initialActivities;
        }

        public ArrayList<String> getListOfStrategies() {
            return listOfStrategies;
        }

        public void setListOfStrategies(ArrayList<String> listOfStrategies) {
            this.listOfStrategies = listOfStrategies;
        }


    }
