public class PolicyEmailWriter {
    private String fileName;

    public PolicyEmailWriter(String filePath) {
        // Create filename with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        fileName = filePath + File.separator + "policy_emails_" + timestamp + ".csv";
    }

    public void writeToCsvUsingOpenCsv(String policyNumber, String email) {
        try {
            // Create or append to CSV file
            File file = new File(fileName);
            boolean fileExists = file.exists();

            // Create directory if it doesn't exist
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            FileWriter outputFile = new FileWriter(file, true); // true for append mode
            CSVWriter writer = new CSVWriter(new FileWriter(file, true),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // Write headers if file is new
            if (!fileExists) {
                String[] headers = {"Policy Number", "Email"};
                writer.writeNext(headers);
            }

            // Write data
            String[] data = {policyNumber, email};
            writer.writeNext(data);

            writer.close();
            System.out.println("Data successfully written to " + fileName);

        } catch (IOException e) {
            System.out.println("Error writing to CSV: " + e.getMessage());
            logger.error("CSV write error: " + e.getMessage());
        }
    }
}
