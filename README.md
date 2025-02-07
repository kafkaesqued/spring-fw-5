array of Policies
// Service Contract
[ServiceContract]
public interface IPolicyService
{
    // Keep existing method for backward compatibility
    [OperationContract]
    PolicyResponse GetPolicyByBillingAccount(string billingAccount);

    // New method to handle array of policy numbers
    [OperationContract]
    BillingAccountArrayResponse GetBillingAccountsByPolicies(string[] policyNumbers);
}

// Data Contracts
[DataContract]
public class PolicyResponse
{
    [DataMember]
    public string BillingAccount { get; set; }

    [DataMember]
    public string PolicyNumber { get; set; }

    [DataMember]
    public string Status { get; set; }
}

[DataContract]
public class BillingAccountArrayResponse
{
    [DataMember]
    public PolicyResponse[] Results { get; set; }

    [DataMember]
    public string Status { get; set; }

    [DataMember]
    public string Message { get; set; }
}

// Service Implementation
public class PolicyService : IPolicyService
{
    public PolicyResponse GetPolicyByBillingAccount(string billingAccount)
    {
        // Your existing implementation
        return new PolicyResponse();
    }

    public BillingAccountArrayResponse GetBillingAccountsByPolicies(string[] policyNumbers)
    {
        if (policyNumbers == null || policyNumbers.Length == 0)
        {
            return new BillingAccountArrayResponse
            {
                Status = "Error",
                Message = "No policy numbers provided",
                Results = Array.Empty<PolicyResponse>()
            };
        }

        var responses = new List<PolicyResponse>();

        foreach (var policyNumber in policyNumbers)
        {
            try
            {
                // Get billing account for each policy number
                string billingAccount = FetchBillingAccount(policyNumber);
                
                responses.Add(new PolicyResponse
                {
                    PolicyNumber = policyNumber,
                    BillingAccount = billingAccount,
                    Status = string.IsNullOrEmpty(billingAccount) ? "NotFound" : "Success"
                });
            }
            catch (Exception ex)
            {
                responses.Add(new PolicyResponse
                {
                    PolicyNumber = policyNumber,
                    Status = "Error",
                    BillingAccount = null
                });
            }
        }

        return new BillingAccountArrayResponse
        {
            Status = responses.All(r => r.Status == "Success") ? "Success" : "PartialSuccess",
            Message = "Processing completed",
            Results = responses.ToArray()
        };
    }

    private string FetchBillingAccount(string policyNumber)
    {
        // Implement your logic to fetch billing account by policy number
        throw new NotImplementedException();
    }
}



array of Billing accounts
// Service Contract
[ServiceContract]
public interface IPolicyService
{
    [OperationContract]
    PolicyResponse GetPolicyByBillingAccount(string billingAccount);

    [OperationContract]
    PolicyArrayResponse GetPoliciesByBillingAccounts(string[] billingAccounts);
}

// Data Contracts
[DataContract]
public class PolicyResponse
{
    [DataMember]
    public string BillingAccount { get; set; }

    [DataMember]
    public string PolicyNumber { get; set; }

    [DataMember]
    public string Status { get; set; }
}

[DataContract]
public class PolicyArrayResponse
{
    [DataMember]
    public PolicyResponse[] Policies { get; set; }

    [DataMember]
    public string Status { get; set; }

    [DataMember]
    public string Message { get; set; }
}

// Service Implementation
public class PolicyService : IPolicyService
{
    public PolicyResponse GetPolicyByBillingAccount(string billingAccount)
    {
        // Existing implementation for single billing account
        if (string.IsNullOrEmpty(billingAccount) || billingAccount.Length != 9)
        {
            return new PolicyResponse 
            { 
                Status = "Error",
                BillingAccount = billingAccount,
                PolicyNumber = null
            };
        }

        // Your existing logic to fetch policy number
        string policyNumber = FetchPolicyNumber(billingAccount);
        
        return new PolicyResponse
        {
            BillingAccount = billingAccount,
            PolicyNumber = policyNumber,
            Status = string.IsNullOrEmpty(policyNumber) ? "NotFound" : "Success"
        };
    }

    public PolicyArrayResponse GetPoliciesByBillingAccounts(string[] billingAccounts)
    {
        if (billingAccounts == null || billingAccounts.Length == 0)
        {
            return new PolicyArrayResponse
            {
                Status = "Error",
                Message = "No billing accounts provided",
                Policies = new PolicyResponse[0]
            };
        }

        var responses = new List<PolicyResponse>();
        
        foreach (var account in billingAccounts)
        {
            responses.Add(GetPolicyByBillingAccount(account));
        }

        return new PolicyArrayResponse
        {
            Status = responses.Any(r => r.Status == "Error") ? "PartialSuccess" : "Success",
            Message = "Processing completed",
            Policies = responses.ToArray()
        };
    }

    private string FetchPolicyNumber(string billingAccount)
    {
        // Your existing implementation to fetch policy number
        throw new NotImplementedException();
    }
}